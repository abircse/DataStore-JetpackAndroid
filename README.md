# JETPACK DATASTORE
An Implementation of JETPACK DATASTORE instead of shared preference to store data using keypair value with asynchronously.

# Uses Technology/Kits
* Coroutines
* Flow

# Why Datastore?
Google introduces Datastore as a replacement for shared preferences. Datastore is a data storage solution for storing small datasets in key-value pairs just like shared preferences, However, the difference is that Datastore uses kotlin and coroutines and flow to handle reading and writing operations on separate threads. Unlike shared preferences, you can get kotlin objects instead of JSON strings when reading data, which makes it easy to work with datastore as compared to shared preferences.
There are many benefits of using data store over shared preferences but a few that will take your attention are:

* Shared preferences are synchronous and run on the main thread, while datastore runs on a separate thread which makes it thread-safe
* Datastore is relatively easy to use as compared to shared preferences and uses a kotlin first approach.
* Async API for storing and reading the data (Flow)
* Safe to call from UI thread (Dispatchers.IO underneath)
* Shared preferences had no mechanism for signalling errors, lack of transactional API, while datastore stores data asynchronously with consistency and transaction support.

# Screenshot
![WhatsApp Image 2022-03-23 at 7 30 44 PM](https://user-images.githubusercontent.com/22006238/159711003-5214329f-82d7-49c8-977a-360fa433fdd5.jpeg)