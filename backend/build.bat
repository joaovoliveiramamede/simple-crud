@echo off
REM Script for building the backend application
echo Building Backend Application...

REM Muda para o diretório onde está o pom.xml
cd backend

REM Verifica se o pom.xml existe
IF NOT EXIST "pom.xml" (
    echo ERROR: pom.xml not found in the backend directory.
    exit /b 1
)

REM Executa o Maven para limpar, compilar e gerar o JAR
echo Running Maven build...
mvn clean install package -DskipTests

REM Verifica se o comando Maven foi bem-sucedido
IF ERRORLEVEL 1 (
    echo ERROR: Maven build failed.
    exit /b 1
)

echo Backend application build completed successfully.
cd ..
