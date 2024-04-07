# Overview

I have always felt that even my favorite sudoku apps fall just short of what I hoped they could be, so I decided to see if I could make a product that could compete with them. This is my first experience developing using Anroid Studio, Kotlin, and Jetpack Compose.  The long term goal is to create a more intuitive and creative interface through which other avid sudoku players like myself can experience the puzzle in a whole new (enhanced) way.

This app is currently able to be opened, navigate between pages, and open your device's storage to access images. It also has the structure through which a puzzle may be saved. A page has been added to display the puzzle, but there is not yet any functionality behind the annotation tool scaffolding.

[Sudoku App Demo](https://drive.google.com/file/d/1ooRO4jCkjlDk3I9RrYda8I3DaEFXZoRc/view?usp=sharing)
[Sudoku App Demo 2](https://drive.google.com/file/d/11FyrjMkL0UvoiellW6KSdnNUsJhd53XS/view?usp=sharing)

# Development Environment

Anroid Studio, Kotlin, Jetpack Compose were used in the development of this app.
The AndroidX libraries of material3, appcompat, and navigation were essential additions to the core libraries.
Update [4/7/2024] : I've added a few key libraries including (but not limited to) page navigation, serialization, and data storage.

# Useful Websites

- [Android Development](https://developer.android.com/)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Material3 Documentation](https://www.composables.com/material3)
- [Gradle Website](https://gradle.org/)
- [Implementing Photo Picker (NEW)](https://proandroiddev.com/implementing-photo-picker-on-android-kotlin-jetpack-compose-326e33e83b85)
- [Custom Serialization](https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/serializers.md#custom-serializers)
- [DataStore Tutorial](https://www.youtube.com/watch?v=yMGAbm84iIY)

# Future Work

- Integrate the ability to take photos (as an alternative to selecting existing photos)
- Connect a codebase that can interpret the image and return a sudoku puzzle
- Implement my own sudoku solving program as a hint giving tool to be used by players
- Create NumberPalette to allow user to click and drag to place numbers
- Create NotesEditor to allow user greater customization of in-cell notes
