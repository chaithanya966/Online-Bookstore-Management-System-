# OnlineBookstore Management System (Eclipse Dynamic Web Project)

Minimal, Tomcat-10 (Jakarta) compatible Java web application scaffold to host on GitHub.

## Project layout (Eclipse Dynamic Web Project, non-Maven)
```
OnlineBookstore/
├─ .project
├─ .classpath
├─ WebContent/
│  ├─ index.jsp
│  ├─ css/
│  └─ WEB-INF/
│     ├─ web.xml
│     └─ views/
│         ├─ header.jsp
│         └─ footer.jsp
├─ src/
│  └─ com/vcube/
│     ├─ handlers/      (servlets — renamed from controller)
│     ├─ repository/    (DAO layer — renamed from dao)
│     ├─ models/        (DTOs — renamed from dto)
│     └─ helpers/       (utilities — renamed from util)
└─ sql/
   └─ bookstore.sql
```

## Package renames requested
- `controller` -> `handlers`
- `dao` -> `repository`
- `dto` -> `models`
- `util` -> `helpers`

## How to run
1. Import this folder as an *Existing Dynamic Web Project* in Eclipse.
2. Add a Tomcat-10 runtime (Tomcat 10 uses Jakarta namespace).
3. Create a MySQL database and run `sql/bookstore.sql`.
4. Update DB credentials in `src/com/vcube/helpers/DBConnection.java`.
5. Run on server.

## GitHub
If you want I can push this to a new repository; provide the repo name and I will give you the git commands.

