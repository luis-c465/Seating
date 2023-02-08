# Seating Chart

Seating Chart App for AP Computer Science AB 2022-2023 in Ivan Rico's class

## Dependencies for running

- [Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) or [higher](https://adoptium.net/)

## Running

- First download the **[Latest release](https://github.com/luis-c465/Seating/releases/latest)**
- Then run in the command line _(Or just double click on the file)_
  ```bash
  java -jar [path to downloaded jar file]
  ```

## Building

### Dependencies

- **[Maven v3.8.4](https://maven.apache.org/download.cgi)**

### How to build

Run the following in the [command line](https://www.freecodecamp.org/news/how-to-use-the-cli-beginner-guide/#how-to-locate-your-cli)

```bash
mvn clean compile assembly:single
```

- Then the **Executable Jar** `seating.jar` will be in the root folder 🎉

## Project Requirements

Due: **Mon, Feb 13 2023** @1 AM

- Displays a seating chart with occupied and non-occupied seats
- Has at least 10 students by default
- Student information can be viewed
  - First/Last name
  - ID
  - date of birth
- Students can be added/removed from the chart
- You can sort the chart in row-major alphabetical order by last name
- You can sort the chart in column major alphabetical order by last name
- You can sort the chart by ID in row-major
- You can sort the chart by ID in column-major
- You can exit the program at any time
