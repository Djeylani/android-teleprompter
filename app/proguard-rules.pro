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