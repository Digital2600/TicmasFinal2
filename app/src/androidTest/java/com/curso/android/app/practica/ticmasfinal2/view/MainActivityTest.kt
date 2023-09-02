package com.curso.android.app.practica.ticmasfinal2.view









import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.ticmasfinal2.R
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith




@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testCompareButton() {
        // Ingresa texto en los EditText
        Espresso.onView(ViewMatchers.withId(R.id.editText1))
            .perform(ViewActions.typeText("Hello"))

        Espresso.onView(ViewMatchers.withId(R.id.editText2))
            .perform(ViewActions.typeText("World"))

        // Cierra el teclado virtual
        Espresso.closeSoftKeyboard()

        // Haz clic en el botón "Comparar"
        Espresso.onView(ViewMatchers.withId(R.id.compareButton))
            .perform(ViewActions.click())

        // Verifica que el resultado TextView muestre el texto esperado
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("No son iguales")))
    }
}