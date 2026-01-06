# Orb

A small Java Swing application (NetBeans project) for simple notes PDF management.

## Features

- User registration and sign-in (Swing forms)
- Admin, VIP, and User management screens
- PDF export utilities (partial)
- MySQL backend via JDBC and MariaDB

## Tech Stack

- Java (JDK 8+; JDK 11 or newer recommended)
- NetBeans project metadata (nbproject/)
- Apache Ant build (build.xml)
- MySQL with the `mysql-connector` JDBC driver

## Quick start (Windows)

1. Install a JDK (11+ recommended) and MySQL Server.
2. Open the project in NetBeans or use Ant from the project root:

```powershell
ant clean
ant build
ant jar
```

3. Configure the database connection in `src/oop/orb/DBConnect.java` (update `url`, `user`, `password`).

4. Run from NetBeans or execute the JAR:

```powershell
java -jar dist\OOP_Orb.jar
```

## Database

The default connection in `DBConnect.java` targets a MySQL database named `OrbRegisters`. Create the database and required tables before running the app. See `docs/DEVELOPER.md` for example schema and setup steps.

## Project structure

- `src/`  Java source (package `oop.orb`)
- `nbproject/`  NetBeans project files
- `build.xml`  Ant build script
- `dist/`  Packaged JAR (after `ant jar`)
- `mysql-connector-j-*.jar`  JDBC driver (recommended to remove from VCS)

## Developer notes & recommendations

- Do not commit database passwords or other secrets. Externalize configuration to a `config.properties` file or environment variables.
- Consider migrating to Maven or Gradle for dependency management and reproducible builds.
- Remove large binaries from the repository and rely on a dependency manager.

## Pushing to GitHub (PowerShell)

```powershell
cd "<path-to-your-project-directory>"
git add .
git commit -m "Project documentation and initial import"
# Replace with your repo URL if you haven't already set origin
git remote add origin https://github.com/<your-username>/<your-repo>.git
git branch -M main
git push -u origin main
```

## Where I changed things

- Added a concise `README.md` and a `docs/DEVELOPER.md` with setup notes.
