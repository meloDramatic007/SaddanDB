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
        implementation 'com.github.meloDramatic007:SaddanDB:1.0.0'
    }
```

# How you can initialize SaddanDB in your project?

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SaddanDB saddanDB;
    }
///
