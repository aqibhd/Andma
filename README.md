
# Andma



![Andma](https://ik.imagekit.io/olnk103lzya/Andma/Andma_logo_IqT_x4rg6Ov.png?updatedAt=1642064128588)


A simple figma-like toast for android 😃
## Prerequisites
Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		mavenCentral()
	}
}
```
## Dependency
Add this to your module's `build.gradle` file (make sure to replace `tag` with version number):

```gradle
dependencies {
	...
	implementation 'com.github.paanTom:Andma:Tag'
}
```
## Usage

This will display a simple default toast with a `DARK` theme (no `icon` will be displayed in the toast):
```java
Andma.show(yourContext,"Show me a default toast",Andma.DARK,Andma.DEFAULT);
```

This will display a simple default toast with a `LIGHT` theme:
```java
Andma.show(yourContext,"Show me a default toast",Andma.LIGHT,Andma.DEFAULT);
```

This will display a success toast with `icon` (we can also change the theme of the toast by switching to DARK or LIGHT):
```java
Andma.show(yourContext,"Show me a success toast",Andma.DARK,Andma.SUCCESS);
```
This will display an info toast with `icon`:
```java
Andma.show(yourContext,"Show me a info toast",Andma.DARK,Andma.INFO);
```
This will display a warning toast with `icon`:
```java
Andma.show(yourContext,"Show me a warning toast",Andma.DARK,Andma.WARNING);
```
This will display an error toast with `icon`:
```java
Andma.show(yourContext,"Show me a error toast",Andma.DARK,Andma.ERROR);
```
You can also set `gravity` and `duration` of the toast: 
```java
Andma.show(yourContext,"Show me a error toast",Andma.DARK,Andma.ERROR,Andma.LONG,Andma.CENTER);
```
This is optional, but if you want to create a custom toast at any given time then call `Andma.Create`: 
```java
Andma.Create.custom()
     .setDrawableIcon(@DrawableRes int resId) //option, you can use this fun to add icon to your toast
     .setDuration(@Duration int duration) // optional
     .setGravity(@Position int position) //optional
     .setBackgroundColor(@ColorRes int resId) //option, you can use this fun to change the background color of your toast
     .setTextColor(@ColorRes int resId) //optinal
     .setTextSize(@Size Float size) //optional
     .setXoffset(int offsetValue) //optional
     .setYoffset(int offsetValue) //optional
     .show(@NonNull Context context, @NonNull CharSequence message,@Type int type); // mandatory, this fun will show your custom toast!
```


## Cover
**Please click the image below to enlarge...**

![Cover](https://ik.imagekit.io/olnk103lzya/Andma/cover_15yH8l_bk.png?updatedAt=1642064396023)


## Authors

- [@AqibHamid](https://www.github.com/paanTom)


## License

* [GPL-3.0 License](https://choosealicense.com/licenses/gpl-3.0/)

```
Andma Copyright (C) 2022  Aqib Hamid

This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
This is free software, and you are welcome to redistribute it
under certain conditions; type `show c' for details.

The hypothetical commands `show w' and `show c' should show the appropriate
parts of the General Public License.  Of course, your program's commands
might be different; for a GUI interface, you would use an "about box".

You should also get your employer (if you work as a programmer) or school,
if any, to sign a "copyright disclaimer" for the program, if necessary.
For more information on this, and how to apply and follow the GNU GPL, see
https://www.gnu.org/licenses 

The GNU General Public License does not permit incorporating your program
into proprietary programs.  If your program is a subroutine library, you
may consider it more useful to permit linking proprietary applications with
the library.  If this is what you want to do, use the GNU Lesser General
Public License instead of this License.  But first, please read
https://www.gnu.org/licenses/why-not-lgpl.html 
```

