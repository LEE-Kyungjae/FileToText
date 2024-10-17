# File to Text Extractor (PPT, PDF, Notion)

This is a Java application that extracts text from files in PPT, PDF formats and saves it to a `.txt` file. The program provides a simple GUI for selecting files, choosing the output location, and converting the text.

## Features

- Extract text from **PPT** files using Apache POI.
- Extract text from **PDF** files using Apache PDFBox.
- Extract text from **Notion** pages using the Notion API.
- User-friendly interface with options to select input and output file paths.

## Prerequisites

Make sure you have the following installed:

- Java 17 or above
- Gradle (optional for building the project)

## Libraries Used

- **Apache POI** for extracting text from PPT files.
- **Apache PDFBox** for extracting text from PDF files.
- **Gson** and **HTTPClient** for working with the Notion API (optional if using Notion API).

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/FileToTextExtractor.git
   cd FileToTextExtractor
