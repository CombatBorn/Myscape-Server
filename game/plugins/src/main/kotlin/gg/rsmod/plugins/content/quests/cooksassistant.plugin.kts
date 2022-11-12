on_button(399, 7){
    player.openInterface(119, InterfaceDestination.MAIN_SCREEN)

        player.setComponentText(interfaceId = 119, component = 2, text = "<col=7f0000>Below Ice Mountain</col>")
        player.setInterfaceEvents(119, 7, 0..200, 0x2)

    for (i in 4 .. 203) {
        player.setComponentText(119, i, "Some example text")
    }


}