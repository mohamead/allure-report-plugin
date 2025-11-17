package com.github.mohamead.allure.report.plugin.provider

import com.github.mohamead.allure.report.plugin.icon.PluginIcons.allure
import com.intellij.ide.IconProvider
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.PsiClassImplUtil
import com.intellij.ui.LayeredIcon
import com.intellij.util.IconUtil
import javax.swing.Icon
import javax.swing.SwingConstants


internal class AllureIconProvider : IconProvider() {

    override fun getIcon(element: PsiElement, flags: Int): Icon? {
        if (element is PsiClass) {
            val psiClass = element
            val qualifiedName = element.qualifiedName

            if (qualifiedName != null && qualifiedName.startsWith("io.qameta.allure.")) {
                return LayeredIcon(2).apply {
                    setIcon(PsiClassImplUtil.getClassIcon(flags, psiClass), 0)
                    setIcon(IconUtil.scale(allure, null, 0.65F), 1, SwingConstants.SOUTH_EAST)
                }
            }
        }
        return null
    }

}