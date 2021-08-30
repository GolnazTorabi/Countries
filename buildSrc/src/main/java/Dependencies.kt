object Versions {
    const val coroutinesVersion = "1.3.9"
    const val roomVersion = "2.3.0-alpha01"
    const val roomKTXVersion = "2.2.0-alpha02"
    const val retrofitVersion = "2.9.0"
    const val gsonVersion = "2.8.6"
    const val picassoVersion = "2.71828"
    const val hiltVersion = "2.35"
    const val interceptorVersion = "4.9.0"
    const val moshiVersion = "1.12.0"
    const val moshiConverter = "2.7.2"
    const val sandwichVersion = "1.1.0"
    const val hiltViewModelVersion = "1.0.0-alpha03"
    const val lifecycleLiveDataVersion = "2.2.0"
    const val lifecycleViewModelVersion = "2.3.0-beta01"
    const val archVersion = "1.1.1"
    const val spannedVersion = "3.0.2"
}

object Coroutines {
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
}

object Room {
    const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKept = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKTX = "androidx.room:room-ktx:2.3.0"
    const val roomCoroutines = "androidx.room:room-coroutines:2.1.0-alpha03"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
    const val interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.interceptorVersion}"
    const val coroutinesNetwork = "com.github.skydoves:sandwich:${Versions.sandwichVersion}"
}

object Picasso {
    const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"
}

object Hilt {
    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
}

object ViewModel {
    const val lifeCycleExt =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleLiveDataVersion}"
    const val lifeCycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelVersion}"
    const val lifeCycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleViewModelVersion}"
    const val arch = "android.arch.lifecycle:extensions:${Versions.archVersion}"
}
object Spanned {
    const val spanned = "com.arasthel:spannedgridlayoutmanager:${Versions.spannedVersion}"
}
