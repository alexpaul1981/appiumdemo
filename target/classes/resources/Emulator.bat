
echo "Killing Adb server"

adb kill-server

timeout /t 5 /nobreak >nul

adb start-server

cd C:\Users\admin\AppData\Local\Android\Sdk\emulator

echo "Starting emulator"

emulator -avd Pixel_3a_Oreo -no-boot-anim
