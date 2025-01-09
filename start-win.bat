@echo off
REM Script for starting Application
echo Starting Docker Application...

REM Verify docker-compose file
IF "%~1" == "" (
    SET "DOCKER_COMPOSE_FILE=docker-compose.yml"
) ELSE (
    SET "DOCKER_COMPOSE_FILE=%~1"
)

echo Using file: %DOCKER_COMPOSE_FILE%

REM Start Docker containers
docker-compose -f "%DOCKER_COMPOSE_FILE%" up -d

REM Config for backend
SET BACKEND_DIR=backend
SET BACKEND_APP_JAR=%BACKEND_DIR%\target\backend.jar

echo jar: "%BACKEND_APP_JAR%"

REM Verify if exist backend.jar file
IF NOT EXIST "%BACKEND_APP_JAR%" (
    echo ERROR: JAR file not found at %BACKEND_APP_JAR%.
    exit /b 1
)

REM Call script for building the backend
echo Calling the backend build script...
call "%BACKEND_DIR%\build.bat"

REM VCerify if JAR was generated
cd ..

IF NOT EXIST "%BACKEND_APP_JAR%" (
    echo ERROR: JAR file not found at %BACKEND_APP_JAR%.
    exit /b 1
)

REM Start application
echo Starting Backend Application...
java -jar "%BACKEND_APP_JAR%"
IF ERRORLEVEL 1 (
    echo ERROR: Failed to start the backend application.
    exit /b 1
)

echo Backend application started successfully.
pause
