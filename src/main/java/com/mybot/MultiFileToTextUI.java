package com.mybot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MultiFileToTextUI {

    public static void main(String[] args) {
        // UI 생성 (스윙 창)
        JFrame frame = new JFrame("File to Text Extractor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        // 파일 형식 선택 콤보박스
        String[] fileTypes = {"PPT", "PDF"};
        JComboBox<String> fileTypeComboBox = new JComboBox<>(fileTypes);
        fileTypeComboBox.setBounds(50, 50, 100, 30);
        frame.add(fileTypeComboBox);

        // 파일 경로 입력 필드
        JTextField filePathField = new JTextField();
        filePathField.setBounds(50, 100, 300, 30);
        frame.add(filePathField);

        // 파일 경로 선택 버튼
        JButton fileSelectButton = new JButton("Select File");
        fileSelectButton.setBounds(360, 100, 120, 30);
        frame.add(fileSelectButton);

        // 텍스트 파일 저장 경로 입력 필드
        JTextField txtPathField = new JTextField();
        txtPathField.setBounds(50, 150, 300, 30);
        frame.add(txtPathField);

        // 텍스트 파일 경로 선택 버튼
        JButton txtSelectButton = new JButton("Save as TXT");
        txtSelectButton.setBounds(360, 150, 120, 30);
        frame.add(txtSelectButton);

        // 변환 버튼
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(200, 200, 100, 30);
        frame.add(convertButton);

        // 실행 결과 라벨
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 250, 400, 30);
        frame.add(resultLabel);

        // 파일 선택 버튼 클릭 이벤트 처리
        fileSelectButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select a File");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                filePathField.setText(selectedFile.getAbsolutePath());
            }
        });

        // 텍스트 파일 저장 버튼 클릭 이벤트 처리
        txtSelectButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save as TXT");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File saveFile = fileChooser.getSelectedFile();
                txtPathField.setText(saveFile.getAbsolutePath());
            }
        });

        // 변환 버튼 클릭 이벤트 처리
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileType = (String) fileTypeComboBox.getSelectedItem();
                String filePath = filePathField.getText();
                String txtFilePath = txtPathField.getText();

                if (filePath.isEmpty() || txtFilePath.isEmpty()) {
                    resultLabel.setText("파일 경로와 TXT 저장 경로를 모두 지정해주세요.");
                    return;
                }

                try {
                    if ("PPT".equals(fileType)) {
                        PPTExtractor extractor = new PPTExtractor();
                        extractor.extractTextFromPPT(filePath, txtFilePath);
                    } else if ("PDF".equals(fileType)) {
                        PDFExtractor extractor = new PDFExtractor();
                        extractor.extractTextFromPDF(filePath, txtFilePath);
                    }
                    resultLabel.setText("텍스트가 성공적으로 저장되었습니다!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    resultLabel.setText("오류 발생!");
                }
            }
        });

        frame.setVisible(true);
    }
}
