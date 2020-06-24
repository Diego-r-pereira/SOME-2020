<!-- My first working on Readme shit -->
# Onboarding-Arduino-Library
Android Library to work on an Onboarding slides, so there is no need to build this from scratch, Thank me later.
___

# Onboarding

* *Onboarding es una libreria que te permitira realizar slides entre fragments con el uzo de un adapter.*
* Esto consiste en que veras en la **pantalla un fragment al que puedes cambiar** con dos imagenes en la arte inferior para navegar entre las pantallas atras o adelante

---

## Installation

> Use the the web page [jitpack](https://jitpack.io/) to use the platform.

Lo primero que tienes que hacer es tener listo el proyecto que quieres volver
libreria o crear uno desde cero.

---
### Convert an app module to a library module

This tutorial is part of [Developer](https://developer.android.com/studio/projects/android-library) site of Android

If you have an **existing app module** with all the code you want to reuse, you can **turn it into a library module** as follows:

1. Open the module-level build.gradle file.
1. Delete the line for the applicationId. Only an Android app module can define this.
1. At the top of the file, you should see the following:

> apply plugin: 'com.android.application'

Change it to the following:

> apply plugin: 'com.android.library'

Save the file and click File > Sync Project with Gradle Files.

---

After that we have to set our proyect in **JITPACK**, to acommplish that our link of the proyect in Github is needed, we paste it on the following space:

![linkJitpack](https://user-images.githubusercontent.com/56709969/68574197-f4b27700-049b-11ea-8727-165f6b313f33.png)

_After that let's settle a release_

![release](https://help.github.com/assets/images/help/releases/releases_description.png)

This is for track the version of our repository, which is worth for **JITPACK**

![release2](https://github.blog/wp-content/uploads/2013/07/bd1cb67e-e329-11e2-90d1-3aecee90739f.jpg?resize=1243%2C633)

After that we got to push over the button named **Look up** as follow:

![jitpack](https://jitpack.io/docs/img/delete.png)

And under that section you can find the way to put this on your own module:

![links](https://miro.medium.com/max/3024/1*yv4gd2JB8wSI0939G_ZjhQ.png)

---

## Now that everything is settle about the configuration is time to use the library

I'll show you the main code and you can see the main events to put on your own

```android
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializeComponents
        _initializeComponents();

        //initializeAdapter
        _initializeFragmentAdapter();
    }
```

```android
    public void _initializeComponents(){
        viewPagerContainer = findViewById(R.id.viewPagerContainer);
    }
```

```android
 public void _initializeFragmentAdapter() {
        OnboardingAdapter adapter = new OnboardingAdapter(getSupportFragmentManager());
        viewPagerContainer.setAdapter(adapter);
    }
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License & copyright
Lincense by [MIT](https://choosealicense.com/licenses/mit/) open source

## Contributors

Rojas Pereira Diego Alejandro