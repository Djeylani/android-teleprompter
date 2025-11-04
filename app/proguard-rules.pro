# ProGuard rules for the Android Teleprompter application

# Keep the main activity and teleprompter view classes
-keep class com.example.androidteleprompter.MainActivity { *; }
-keep class com.example.androidteleprompter.TeleprompterView { *; }

# Keep all public methods and fields in the application
-keep public class * {
    public *;
}

# Keep the names of the classes and methods for reflection
-keepnames class * {
    <fields>;
    <methods>;
}

# Keep the application class
-keep class com.example.androidteleprompter.Application { *; }

# Keep the model classes
-keep class com.example.androidteleprompter.model.** { *; }

# Keep the Parcelable implementation
-keep class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
# Please add these rules to your existing keep rules in order to suppress warnings.
# This is generated automatically by the Android Gradle plugin.
-dontwarn android.window.SplashScreen
-dontwarn android.window.SplashScreen$OnExitAnimationListener
-dontwarn android.window.SplashScreenView
-dontwarn android.window.SplashScreenView$OnExitAnimationListener

# Automatically added from R8 missing_rules.txt to suppress warnings
-dontwarn javax.lang.model.element.Modifier