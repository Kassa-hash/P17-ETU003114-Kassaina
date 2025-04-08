@echo off
setlocal enabledelayedexpansion

set APP_NAME=TP-emp-dept
set SRC_JAVA_DIR=src\java
set WEB_DIR=src\webapp
set BUILD_DIR=build
set LIB=lib
set TOMCAT_WEBAPPS=C:\Tomcat\apache-tomcat-10.1.28\webapps

:: Nettoyage et création du répertoire temporaire (build)
rmdir /S /Q %BUILD_DIR%
mkdir %BUILD_DIR%\WEB-INF\classes

:: Construction du CLASSPATH avec tous les fichiers .jar du dossier LIB
set CLASSPATH=
for %%i in (%LIB%\*.jar) do (
    set CLASSPATH=!CLASSPATH!;%%i
)

:: Suppression du premier ";" si nécessaire
set CLASSPATH=%CLASSPATH:~1%

:: Vérification si CLASSPATH est vide
if "%CLASSPATH%"=="" (
    echo Erreur: Aucun fichier JAR trouvé dans %LIB%.
    exit /B
)

:: Trouver tous les fichiers .java et les écrire dans sources.txt
dir /B /S %SRC_JAVA_DIR%\*.java > sources.txt

:: Vérification si sources.txt est vide
if not exist sources.txt (
    echo Aucun fichier .java trouvé dans %SRC_JAVA_DIR%.
    exit /B
)

:: Compilation des fichiers Java avec --release 17
javac --release 17 -cp "%CLASSPATH%" -d %BUILD_DIR%\WEB-INF\classes @sources.txt
if %ERRORLEVEL% neq 0 (
    echo Erreur lors de la compilation des fichiers Java.
    exit /B
)

:: Supprimer le fichier sources.txt
del sources.txt

:: Copier les fichiers web (web.xml, JSP, etc.)
xcopy %WEB_DIR%\* %BUILD_DIR%\ /E /H /I  
xcopy %LIB%\* %BUILD_DIR%\WEB-INF\lib /E /H /I

:: Changer de répertoire vers BUILD_DIR
cd %BUILD_DIR% || (
    echo Impossible de changer de répertoire vers %BUILD_DIR%.
    exit /B
)

:: Création du fichier .war
jar -cvf %APP_NAME%.war *
if %ERRORLEVEL% neq 0 (
    echo Erreur lors de la création du fichier .war.
    exit /B
)

:: Revenir au répertoire précédent
cd ..

:: Déploiement vers Tomcat
copy /Y %BUILD_DIR%\%APP_NAME%.war %TOMCAT_WEBAPPS%
if %ERRORLEVEL% neq 0 (
    echo Erreur lors du déploiement vers Tomcat.
    exit /B
)

echo.
echo Déploiement terminé. Redémarrez Tomcat si nécessaire.
echo.

endlocal
