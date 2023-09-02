package com.curso.android.app.practica.ticmasfinal2.view
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.ticmasfinal2.model.ComparisonResult
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito


@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var comparisonResultObserver: Observer<ComparisonResult>


    @Before
    fun setup() {
        viewModel = MainViewModel()

    }

    @Test
    fun testCompareStrings_EqualStrings() {
        viewModel.compareStrings("Hello", "Hello")
        Mockito.verify(comparisonResultObserver).onChanged(ComparisonResult(true))
    }

    @Test
    fun testCompareStrings_DifferentStrings() {
        viewModel.compareStrings("Hello", "World")
        Mockito.verify(comparisonResultObserver).onChanged(ComparisonResult(false))
    }
}

class InstantTaskExecutorRule {

}


