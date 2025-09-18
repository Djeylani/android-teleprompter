# Android Teleprompter

## Overview
The Android Teleprompter application is designed to provide a simple and effective way to display scrolling text for presentations, speeches, or any other public speaking engagements. This application allows users to input their script and control the scrolling speed and text alignment.

## Features
- User-friendly interface for inputting scripts.
- Customizable scrolling speed.
- System overlay that works over camera apps.
- Automatic camera launch with text overlay.
- Touch controls for pause/resume scrolling.
- Compact overlay design (top 1/3 of screen).
- Compatible with native camera recording.

## Project Structure
The project is organized as follows:

```
android-teleprompter
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── kotlin
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── androidteleprompter
│   │   │   │               ├── MainActivity.kt
│   │   │   │               └── TeleprompterView.kt
│   │   │   ├── res
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   └── view_teleprompter.xml
│   │   │   │   ├── values
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── colors.xml
│   │   │   │   └── menu
│   │   │   │       └── menu_main.xml
│   │   │   └── AndroidManifest.xml
│   │   ├── test
│   │   │   └── java
│   │   │       └── com
│   │   │           └── example
│   │   │               └── androidteleprompter
│   │   │                   └── ExampleUnitTest.kt
│   │   └── androidTest
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── androidteleprompter
│   │                       └── ExampleInstrumentedTest.kt
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
├── gradle
│   └── wrapper
│       └── gradle-wrapper.properties
└── README.md
```

## Setup Instructions
1. Clone the repository: `git clone https://github.com/Djeylani/android-teleprompter.git`
2. Open the project in Android Studio.
3. Ensure that you have the necessary SDKs and dependencies installed.
4. Build and run the application on an Android device or emulator.

## Usage
- Launch the application and input your script in the provided text area.
- Adjust the scrolling speed using the slider.
- Press "Start Teleprompter" to launch the overlay.
- Grant overlay permission when prompted.
- The camera app will open automatically with teleprompter text overlay.
- Use the camera's native record button to start/stop recording.
- Tap the text area to pause/resume scrolling.
- Use the speed control and close button in the overlay.

## Building Release APK
1. Update `keystore.properties` with your keystore credentials.
2. Run: `./gradlew assembleRelease`
3. Find APK in: `app/build/outputs/apk/release/`

## Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue for any suggestions or improvements.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.