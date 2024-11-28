@echo off
REM Script for building the backend application
echo Building Backend Application...

REM Muda para o diretório onde está o pom.xml
cd frontend

REM Verifica se o pom.xml existe
IF NOT EXIST "package.json" (
    echo ERROR: package.json not found in the front directory.
    exit /b 1
)

REM Install dependencies
echo Running install dependencies
npm install

REM Verify if command success
IF ERRORLEVEL 1 (
    echo ERROR: npm install failed.
    exit /b 1
)

REM Build project
echo Running install dependencies
npm run build:dev

REM Verify if command success
IF ERRORLEVEL 1 (
    echo ERROR: npm run build:dev failed.
    exit /b 1
)

echo Frontend Angular application build completed successfully.
cd ..
