package com.example.testingfragmentsinisolation.ui.movie

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(DirectorsFragmentTest::class ,MovieDetailFragmentTest::class ,StarActorsFragmentTest::class ,MovieNavigationTest::class)
class AllFragmentsTestSuite