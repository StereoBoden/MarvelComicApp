# Marvel Comic App
Open Source App using Marvel's public API
https://developer.marvel.com/

# Features
- Reads Marvel Comic API data and displays multiple comic series' to the user
- User can select a series and look at individual comics

# Project Summary
- Pure Kotlin
- MVVM Architecture
- Networking using Retrofit/OkHttp
- Asynchronous calls using Coroutines
- DI Using Koin
- Storing results to DB using Room
- Using groupie for Recyclerview items
- Glide for image loading
- Jetpack Navigation Component for screen navigation
- Ktlint for code linting

# Building the App
- Register an Account and get API public and private keys at https://developer.marvel.com/account
- Locate `Constants.kt` in the codebase and replace `API_KEY` with the public key and `PRIVATE_KEY` with the private key

# Known Issues
- Running on an emulator API 28 was having general performance issues
- Rotating the screen performs an API call again (activity is destroyed and redrawn)

# Problems Building with ktlint?
- If there are any problems building when ktlint is throwing errors, it can be disabled by simply removing 'preBuild.dependsOn('ktlintCheck')' from the bottom of 'build.gradle'