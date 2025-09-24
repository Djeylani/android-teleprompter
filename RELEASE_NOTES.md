# Android Teleprompter v1.2 Release Notes

## 🎉 Major Update: Camera Overlay Functionality

### New Features
- **Camera Integration**: Automatically launches camera app with teleprompter overlay
- **System Overlay**: Text displays over camera view for seamless recording
- **Compact Design**: Overlay covers only top 1/3 of screen, leaving camera controls accessible
- **Auto-Scroll**: Text starts scrolling automatically when overlay appears
- **Touch Control**: Tap anywhere on text to pause/resume scrolling
- **Speed Control**: Real-time speed adjustment with slider
- **Native Recording**: Use camera app's native record button for video capture

### Technical Improvements
- **Overlay Service**: Background service ensures overlay stays visible
- **Permission Handling**: Automatic overlay permission request
- **Performance**: Optimized for smooth scrolling and minimal battery usage
- **Compatibility**: Works with Android 5.0+ (API 21+)

### How to Use
1. Enter your script in the main app
2. Adjust scrolling speed with slider
3. Press "Start Teleprompter"
4. Grant overlay permission when prompted
5. Camera opens automatically with text overlay
6. Use camera's record button to start/stop recording
7. Tap text to pause/resume scrolling
8. Use close button (X) to exit overlay

### Download
- **APK**: `android-teleprompter-v1.2-signed.apk`
- **Size**: ~8MB
- **Target SDK**: Android 13 (API 33)
- **Min SDK**: Android 5.0 (API 21)

### Installation
1. Download the APK file
2. Enable "Install from unknown sources" in Android settings
3. Install the APK
4. Grant camera and overlay permissions when prompted

### Known Issues
- First launch requires overlay permission grant
- Some camera apps may behave differently with overlay

### Next Version Plans
- Text size adjustment
- Background color options
- Multiple script management
- Export/import functionality