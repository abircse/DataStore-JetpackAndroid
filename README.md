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
![Screenshot_9](https://user-images.githubusercontent.com/22006238/159722583-f060878f-e6bb-40f5-9343-f933796ad74c.png)
