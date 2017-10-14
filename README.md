
# MyDog: Documentation

**DESIGN PROCESS**

**Problem Statement** : With cities across the United States banning the sales of commercially bred animals within pet stores, comes increasing demands amongst consumers for animal adoption.  In addition, animal shelters are frequently underfunded, leaving them without proper resources to advertise their pets for adoption. Currently there lacks an effective mobile application for both consumers and breeders to efficiently browse animals for adoption.  The closest alternative AllPaws from iOS app store, developed by PetSmart for store-specific use, lacks much consumer selection in terms of preferences.

**Objective:** Our goal for this project is to develop a mobile application that gives potential owners an easy method to browse for pets, while providing shelters with a channel to advertise their pets to a broader audience. The application will work as a similar fashion to Tinder, except that there is a clear two-way interaction between shelters and consumers.

**Problem Scenarios**

With numerous dog shelters located all over the state, our team thought about some possible problem scenarios in which our app would be the perfect solution to the user. These are some scenarios that we came up with:

- A dog shelter is becoming overcrowded, and is in desperate need to publicize the dogs they currently have; however, they do not have the funding for advertisements from local advertising agencies.**
- A dog lover is interested in adopting a dog, but they are not able to make it to their local dog shelter.**

Our overall design philosophy and use cases to drive iterative design:

- Want the user to have the ability to browse through the most number pet listings in the shortest amount of time
- Minimize reading through each swipe
- Reliance on visual cues to identify preferences

- Usage with only one hand for most of the time
- Ease to learn and use

**Initial Design:**

Initially our design focus for the application is to make a &quot;Tinder for Dogs&quot;

- Swipe interface to save, skip through listings and selections
- A way to quickly access dogs that were swiped right, identified as &quot;saved pets&quot;
- Besides swiping, two buttons are placed to represent swiping motions, for users who prefer using buttons instead of swiping

**Second Iteration**
We realized that there lacks a method for animal shelters, or current pet owners, to populate the listings for the application, which prompts us to provide a two-way model to generalize our application&#39;s interactions:


- Users looking to adopt a dog
- Users looking for a new home for an dog

We decided to have the application to greet users with two choices, depending on their needs.  One is to put up the user&#39;s pet for adoption, the other is for users who are in search for a new pet.

Users who are looking to put up with a listing will have list to complete before submitting the listing to populate the database.

Users who are looking for a new pet are direct to the swipe screen, where they can meet new doggos and have access to a list of dogs they saved earlier

**Third Iteration**

In addition to the two-way interaction, we decided to add a third component to the application to cater each individual user&#39;s needs.  We implemented a sign in screen which gives the following functionalities:

- Method for new users to sign up an account within the application
- Sign up requires a set of information to be filled
- Users can have access to forgotten passwords after answering their designated security question

- Users who do not desire to sign up are directly taken to the home screen to continue

**Final Iteration**

Final brush up on sign in screen, we want a smoother experience for initial users in order provide them with quicker access to the main screen.

- Added splash screen with extra simple design
- Immediately presents users with an option to continue as guest


**Future Opportunities/Further Implementations**

There are a few ideas we&#39;ve came up for added functionality within the application, which may be developed in our leisure.  Here is our vision for the future of this application.

- Sorting algorithm to arrange listing for swipe interface.
- Location identified listings
- User preferences
- Interface to set up shelter information sections
- Means for pet owners to provide documentation of their pets, such as vaccine cards etc, entirely within the application

**Resources used**

- [**https://github.com/flschweiger/SwipeStack/blob/master/README.md**](https://github.com/flschweiger/SwipeStack/blob/master/README.md)
- [**https://developer.android.com/training/material/lists-cards.html**](https://developer.android.com/training/material/lists-cards.html)
- [**https://stackoverflow.com/questions/24449344/using-android-support-v7-widget-cardview-in-my-project-eclipse**](https://stackoverflow.com/questions/24449344/using-android-support-v7-widget-cardview-in-my-project-eclipse)
