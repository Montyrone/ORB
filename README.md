# OOP Orb

A Java Swing/NetBeans desktop application for user registration and management (project by Charles Montero).

## Features

- User registration and sign-in UI (Swing forms)
- Admin and VIP management screens
- PDF export/management (partial)
- MySQL database backend (JDBC)

## Tech Stack

- Java 17+ (or Java 8+ compatible with NetBeans project settings)
- NetBeans (project files under `nbproject/`)
- Apache Ant (`build.xml` provided)
- MySQL (JDBC) — `mysql-connector` JAR is present in repository

## Quick Start (Windows)

1. Install Java (JDK 11 or newer recommended) and MySQL Server.
2. Open the project in NetBeans or build with Ant from the project root:

```powershell
# Build with Ant (from project root)
ant clean
ant build
ant jar
```

3. Configure database connection in `src/oop/orb/DBConnect.java` — update the `url`, `user`, and `password` values to match your MySQL setup.

4. If running from NetBeans, use Run → Run Project. If running the produced JAR, use:

```powershell
java -jar dist\OOP_Orb.jar
```

## Database

The project expects a MySQL database named `OrbRegisters` (see `DBConnect.java`). Create the database and the required tables before running the app. See `docs/DEVELOPER.md` for a minimal schema and setup steps.

## Project Structure

- `src/` — Java source, package `oop.orb`
- `nbproject/` — NetBeans project metadata
- `build.xml` — Ant build script
- `dist/` — Built JAR (if present)
- `mysql-connector-j-*.jar` — JDBC driver included (consider using Maven/Gradle or external dependency management)

## Notes & Recommendations

- Sensitive credentials should not be committed. Update `DBConnect.java` with safe defaults and consider externalizing configuration to a properties file or environment variables.
- The repository currently contains a JDBC driver JAR and build artifacts (`dist/`, `build/`). Consider removing these from the repo and adding them to `.gitignore`.

## Pushing to GitHub (PowerShell)

```powershell
cd "c:\Users\Charles\OneDrive\Desktop\OOP Orb"
# Initialize repo locally
git init
git add .
git commit -m "Initial import: OOP Orb"
# Create repository on GitHub (manually or using gh CLI), then add remote and push
# Replace <REMOTE_URL> with your GitHub repo URL
git remote add origin <REMOTE_URL>
git branch -M main
git push -u origin main
```

If you want, I can create a `.gitignore` and a small `docs/` folder with developer notes now, and provide exact commands tailored to your GitHub repo URL.
