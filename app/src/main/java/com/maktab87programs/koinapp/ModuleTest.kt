package com.maktab87programs.koinapp

class ModuleTest {
    val appModule = module {
        factory { B() }
        factory { A(get()) }
    }

}