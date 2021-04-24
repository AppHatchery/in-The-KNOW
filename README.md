# In-The-KNOW
In-The-KNOW is an Android mobile application that’s focused on HIV prevention for African American women. In-the-KNOW users can interact with the application using the following features: 
1. logging their sexual history (My Logger)
2. visualizing data on their feelings (My Feelings)
3. finding the nearest drugstores (My Tests)
4. receiving proper health information (My Resources)
5. chatting with nearby users (My Circle)


**Release Notes:** \
in-the-KNOW version 1.0.1 \
NEW FEATURES: 
- Updated myResources with the data that was provided (podcasts, testing locations, resource videos, support group information).
- The UI of myResources and myLogger has been completely revamped for a much better user experience.
- The myCircle chatting functionality using ChatSDK Firebase has effectively replaced the original myCircle for a more complete chatting experience (includes direct messaging and chat-rooms).
- The myLogger symptom-based questionnaire is displayed immediately upon entering myLogger, rather than the myLogger data itself.
- The symptom-based and event-based questionnaires have been separated in myLogger.
- Pie charts displaying essential data from the user’s myLogger events have been added to the home screen of myLogger in order to effectively show important trends in their data.
- A direct link to myResources has been added in myLogger for increased convenience.

BUG FIXES: 
- Fixed reverse navigation in creating a new log entry in MyLogger
- Fixed layout issues on MyLogger and MyResources for devices with lower resolution than 1080 x 2220
- Fixed text wrapping issues on pie-chart visualization in MyLogger

KNOWN BUGS:
- The Google Sign-in feature is known to crash on some devices. If this is an issue that is encountered, we recommend using the standard login system for the application.
- It has been found that on some devices, it is impossible to return to the in-the-Know home screen from the myCircle feature which is driven by ChatSDK firebase. If this is encountered, one can return back by simply restarting the application as of right now.

**Install Guide:**

Pre-requisites:
- In order to simply run an application on a given Android phone, the only prerequisite is that one must be running Android version 4.4 (KitKat). This Android version corresponds to API Level 19. You may see more details about this Android version at: https://developer.android.com/about/versions/kitkat
However, if one wishes to compile the project and test it on an emulator, then an emulator must be chosen with SDK version 30. This version is available in most modern devices. The Android Studio environment installs the latest JDK version, but if another environment is used, then JDK 8 must be installed as well.

Dependent Libraries: 
- There are no dependent libraries that need to be installed separately from the contents of the given repository.

Download Instructions:
- If one wishes to simply download the apk file in order to run the application on an Android device, it would be easiest to access this link on that given device, so that the apk may be downloaded directly onto the device to be immediately installed:
https://drive.google.com/drive/folders/1oQbCHehA6WENGfvYg6jZ913m5_3_FOLG?usp=sharing
- However, if it is desired to run the application through an emulator and Android Studio, the project would need to be cloned from Github. Upon opening Android Studio, click “Get from Version Control.” Afterwards, enter in the URL to the repository: “https://github.com/nealbayya/in-The-KNOW,” and select the directory where the project should be downloaded to. Afterwards, click “Clone,” and the project should be downloaded to the computer.

Build Instructions: 
- No building is necessary if the apk file has already been downloaded in order to be installed on an Android device. This step may be skipped.
However, if one wishes to build the application on Android Studio in order to run the project on an emulator, one can click the hammer button at the top of the IDE. Alternatively, one can click the Build menu on the top, and click “Make Project” in order to effectively build the project. Note that running the project (seen in Running Instructions) also builds the application as part of the process.

Application Installation:
- In order to run the application on an Android device, the apk file should be first downloaded from the project github repository. Afterwards, the file manager should be opened on the Android device, and the apk should be located and selected. An installation prompt will then be opened, from which the application can be installed onto the device by following the instructions.
- In order to install the application on an emulator through Android Studio, click on the emulator selection menu on the top, and ensure that the emulator that was created during Android Studio setup has been selected. Click the play button next to it, and then Android Studio will not only build the project, but also install the application onto the emulator that was selected.

Running Instructions:
- In order to run the application from an Android phone where the apk file has already been installed, the icon corresponding to the application can simply be clicked. If this icon is not found, one can go to the phone’s search bar and type in-the-Know in order to locate the application in the phone.
- In order to run the application on an emulator through Android Studio, click on the emulator selection menu on the top, and ensure that the emulator that was created during Android Studio setup has been selected. Click the play button next to it, and then Android Studio will build the project and install/run the application on the emulator.

Troubleshooting:
- In the case that Google-SignIn crashes (which has been observed on the PixelXL with API Level 30), the user may use the in-app registration and login system.
- If the user cannot navigate from MyCircle to the homepage through the back button, then the user must restart the app to return home.
- If read/write access is denied in the chat rooms of MyCircle, then you must contact the application developers. This issue is caused by an expiration of the cloud database services, and may only be fixed by the original developers.

