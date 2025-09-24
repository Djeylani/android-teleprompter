# Android Teleprompter v1.3 Release Notes

## 🎯 Major Update: Script Management & Text Customization

### New Features
- **Script Persistence**: Scripts automatically save and restore between sessions
- **Multiple Script Management**: Save, load, and organize unlimited named scripts
- **Text Size Control**: Adjustable font size (16-48sp) with live preview
- **Auto-Save**: Never lose your work - everything saves automatically
- **Script Library**: Build a collection of scripts for different occasions

### Enhanced User Experience
- **Save Scripts**: Name and save scripts for future use
- **Load Scripts**: Quick access to all saved scripts via dialog
- **Live Preview**: See text size changes instantly in editor
- **Persistent Settings**: Speed and text size preferences remembered
- **Improved Interface**: Clean layout with organized controls

### Technical Improvements
- **SharedPreferences Storage**: Reliable local script storage
- **Memory Efficient**: Optimized script management system
- **Crash Resistant**: Auto-save prevents data loss
- **Backward Compatible**: All existing features preserved

### How to Use
1. **Script Management**:
   - Enter script text (auto-saves as you type)
   - Tap "Save" to name and store script permanently
   - Tap "Load" to select from saved scripts
   
2. **Text Customization**:
   - Use "Text Size" slider to adjust font (16-48sp)
   - See changes instantly in editor
   - Size applies to both editor and teleprompter overlay

3. **Teleprompter**:
   - Adjust speed and text size as needed
   - Press "Start Teleprompter" for camera overlay
   - All settings carry over to overlay display

### What's Improved from v1.2
- ✅ **Script Persistence** - No more lost scripts
- ✅ **Multiple Scripts** - Save unlimited named scripts  
- ✅ **Text Size Control** - Perfect size for any distance
- ✅ **Better UI** - Organized controls and clear labels
- ✅ **Auto-Save** - Automatic data protection

### Download
- **APK**: `android-teleprompter-v1.3-signed.apk`
- **Size**: ~8MB
- **Target SDK**: Android 13 (API 33)
- **Min SDK**: Android 5.0 (API 21)

### Installation
1. Download the APK file
2. Enable "Install from unknown sources" in Android settings
3. Install the APK (will update existing v1.2 installation)
4. Grant camera and overlay permissions when prompted

### Known Issues
- First launch requires overlay permission grant
- Some camera apps may behave differently with overlay

### Next Version Plans
- Background color/transparency options
- Progress indicator showing script position
- Restart button to jump to beginning
- Voice control commands
- Export/import scripts functionality