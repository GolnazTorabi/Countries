object Versions {
    const val coroutinesVersion = "1.3.9"
    const val roomVersion = "2.3.0"
    const val retrofitVersion = "2.9.0"
    const val gsonVersion = "2.8.6"
    const val picassoVersion = "2.71828"
    const val hiltVersion = "2.35"
    const val interceptorVersion = "4.9.0"
    const val moshiVersion = "1.12.0"
    const val moshiConverter = "2.7.2"
    const val sandwichVersion = "1.1.0"
    const val hiltViewModelVersion = "1.0.0-alpha01"
}

object Coroutines {
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
}

object Room {
    const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKept = "androidx.room:room-compiler:${Versions.roomVersion}"
    //const val roomCoroutines = "androidx.room:room-coroutines:${Versions.roomVersion}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptorVersion}"
    const val coroutinesNetwork = "com.github.skydoves:sandwich:${Versions.sandwichVersion}"
}

object Picasso {
    const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"
}

object Hilt {
    const val hiltClassPath =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
    const val hiltViewModel ="androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModelVersion}"
    const val hiltCompilerKapt = "androidx.hilt:hilt-compiler:${Versions.hiltViewModelVersion}"
}
