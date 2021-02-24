package com.akexorcist.localizationapp.darktheme

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.commit
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivityDarkThemeBinding

class DarkThemeActivity : LocalizationActivity() {
    private val binding: ActivityDarkThemeBinding by lazy { ActivityDarkThemeBinding.inflate(layoutInflater) }

    companion object {
        private const val KEY_SCROLL_X = "scroll_x"
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.layoutLanguageChooser.btnAmerica.setOnClickListener { setLanguage("en") }
        binding.layoutLanguageChooser.btnChina.setOnClickListener { setLanguage("zh") }
        binding.layoutLanguageChooser.btnItaly.setOnClickListener { setLanguage("it") }
        binding.layoutLanguageChooser.btnJapan.setOnClickListener { setLanguage("ja") }
        binding.layoutLanguageChooser.btnKorea.setOnClickListener { setLanguage("ko") }
        binding.layoutLanguageChooser.btnPortugal.setOnClickListener { setLanguage("pt") }
        binding.layoutLanguageChooser.btnThai.setOnClickListener { setLanguage("th") }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(binding.layoutFragmentContainer.id, DarkThemeFragment.newInstance())
            }
        }
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        // Save x-position of horizontal scroll view.
        outState.putInt(KEY_SCROLL_X, binding.layoutLanguageChooser.svLanguageChooser.scrollX)
        super.onSaveInstanceState(outState)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore x-position of horizontal scroll view.
        binding.layoutLanguageChooser.svLanguageChooser.scrollTo(savedInstanceState.getInt(KEY_SCROLL_X), 0)
    }
}
