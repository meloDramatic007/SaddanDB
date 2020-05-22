# SaddanDB

SaddanDB is shared preference based data container where you can save any type of objects List in shared preference.

## Where should you use SaddanDB in your project?

* When you are using Retrofit it returns responses as List,you can save this List in SaddanDB and use it whenever you need  without calling Retrofit


# Getting Started

add this in your `project level build.gradle` file

```java
allprojects {
   repositories {
 maven { url 'https://jitpack.io' }
 }
}
```

add this dependency in your `app level build.gradle` file

```java

dependencies {
        implementation 'com.github.meloDramatic007:SaddanDB:1.0.3'
    }
```

# How you can initialize SaddanDB in your project?

```java
public class MainActivity extends AppCompatActivity
{
    private  String TAG =getClass().getSimpleName() ;
    private SaddanDB saddanDB;
    List<Movie> movieList=new ArrayList<>();
    List<Movie> list_From_SaddanDB=new ArrayList<>();

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saddanDB=new SaddanDB(this);
        movieList.add(new Movie("hulk","1995"));
        movieList.add(new Movie("Spider women","1995"));
        
        saddanDB.setList("movie",movieList);
        list_From_SaddanDB= (List<Movie>) saddanDB.getList("movie",Movie.class);

        for(Movie movie:list_From_SaddanDB)
        {
            Log.d(TAG, "onCreate: "+movie.getName());
        }
        
        //to clear all the saved list's
        saddanDB.ClearData();
        

    }
}



* use  ```@SuppressWarnings("unchecked")``` to avoid ```Type safety: Unchecked cast from Object``` warning.
