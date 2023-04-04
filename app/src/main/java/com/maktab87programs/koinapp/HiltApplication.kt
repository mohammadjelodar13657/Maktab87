package com.maktab87programs.koinapp

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideName(): String = "Tesla"
    @Provides
    fun provideEngine() = Engine("Electric")

    @Provides
    @Named("Tesla")
    fun provideTeslaCar() = Car("Tesla", Engine("Electric"))

    @Provides
    @Named("Honda")
    fun provideHondaCar() = Car("Honda", Engine("Gas"))
}
------------------------------------------------------------------------
class Car @Inject constructor(
    private var name: String,
    private var engine: Engine
) {
    fun start(): String {
        return " started"
    }

    fun carDescribe(): String {
        return "$name with $engine"
    }
}
------------------------------------------------------------------------
@HiltAndroidApp
class CarApplication : Application()
data class Engine @Inject constructor(private val name: String)
------------------------------------------------------------------------
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    @Inject
    @Named("Honda")
    lateinit var hondaCar: Car

    @Inject
    @Named("Tesla")
    lateinit var teslaCar:Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e(TAG, "onCreate: ${hondaCar.carDescribe()} ${hondaCar.start()}")

        Log.e(TAG, "onCreate: ${teslaCar.carDescribe()} ${teslaCar.start()}")

    }
}
