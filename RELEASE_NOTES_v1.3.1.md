# Android Teleprompter v1.3.1 Release Notes

## 🔄 Update: Platform Compatibility & Stability

### What's New
- **Google Play Compliance**: Updated targetSdk to Android 14 (API 34)
- **R8 Optimization**: Improved app packaging and stability
- **Build System**: Enhanced ProGuard/R8 configuration

### Technical Improvements
- **Target SDK**: Upgraded to Android 14 (API 34) for Google Play compliance
- **Build Tools**: Optimized R8 shrinking and obfuscation
- **Compatibility**: Maintains support for Android 5.0+ (API 21+)

### All Features from v1.3
- **Script Management**:
  - Auto-save and restore scripts
  - Save unlimited named scripts
  - Quick script loading
- **Text Customization**:
  - Adjustable font size (16-48sp)
  - Live preview
  - Persistent settings
- **Camera Overlay**:
  - Automatic camera integration
  - Text overlay for recording
  - Touch controls for pause/resume
  - Speed adjustment slider

### Download
- **APK**: `app/release/app-release.apk`
- **Size**: ~4.3MB (optimized)
- **Target SDK**: Android 14 (API 34)
- **Min SDK**: Android 5.0 (API 21)
- **Version Code**: 5
- **Version Name**: 1.3.1

### Installation
1. Download the APK file
2. Enable "Install from unknown sources" in Android settings if needed
3. Install the APK (will update existing v1.3 installation)
4. Grant camera and overlay permissions when prompted

### Known Issues
- First launch requires overlay permission grant
- Some camera apps may behave differently with overlay

### Building from Source
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Build using Gradle wrapper:
   ```bash
   ./gradlew assembleRelease
   ```
5. Find signed APK in `app/release/app-release.apk`

### Requirements for Building
- Android Studio Giraffe or newer
- JDK 11 or newer
- Android SDK with API 34 platform
- Valid keystore for app signing

### Next Version Plans
- Background color/transparency options
- Progress indicator showing script position
- Restart button to jump to beginning
- Voice control commands
- Export/import scripts functionality