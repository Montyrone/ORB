Developer Notes

1) Database setup

- Create a MySQL database named `OrbRegisters`:

```sql
CREATE DATABASE OrbRegisters;
USE OrbRegisters;
```

- Minimal `users` table example (adapt to your needs):

```sql
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  role VARCHAR(20),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

2) JDBC driver

- The repository includes `mysql-connector-j-*.jar`. It's recommended to remove large binary dependencies from VCS and instead manage them via a build tool (Maven/Gradle) or document where to download them.

3) Configuration

- Update `src/oop/orb/DBConnect.java` with your DB credentials or modify the code to read from an external `config.properties` or environment variables.

4) Build & Run

- Use Ant (`ant clean`, `ant build`, `ant jar`) or open the project in NetBeans and run.

5) Next improvements (suggested)

- Externalize configuration to `config.properties` or environment variables.
- Add a simple `README` for each major module (Admin, PDF management).
- Consider migrating to Maven/Gradle for dependency management and reproducible builds.
