
![](poster.jpg)

## Client did not pay?


Add opacity to UI components and decrease it every day until their app completely fades away. Set a due date and customize the number of days you offer them until the app is fully vanished. 


```kotlin
/*You can change these variables as you wish */
Faded.init(
    dueDate = "2019-20-02",
    daysDeadline = 30
)
```

## Installation

NOTE: will be only available from Feb 15 2019 00:00 EST

```groovy
implementation 'com.theah64.faded:faded.1.0.0'
```

## Usage

```kotlin
/*In your application class, init faded like this*/
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Faded.init(
            dueDate = "2019-20-02",
            daysDeadline = 30
        )
    }
}

/*In your activities, wrap the base context with Faded */
class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(Faded.wrap(newBase!!))
    }
}

```

That's it!

## Author

Inspired from github (@kleampa)

Made by theapache64
