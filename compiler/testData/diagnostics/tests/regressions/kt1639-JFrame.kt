package test

import javax.swing.JFrame

class KFrame() : JFrame() {
    {
        val <!UNUSED_VARIABLE!>x<!> = this.rootPaneCheckingEnabled // make sure field is visible
    }
}
