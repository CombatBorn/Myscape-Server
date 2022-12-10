enum class InterfaceEvent
/**
 * Constructs a new [InterfaceEvent]
 *
 * @param flag The value of the event.
 */(
    /**
     * The integer representation of the event.
     */
    val flag: Int
) {
    /**
     * Enabled the component to be a "pause_button", clicking it sends [DialogueReader].
     */
    PAUSE(1 shl 0),

    /**
     * Enables op1 on the component.
     */
    BUTTON1(1 shl 1),

    /**
     * Enables op2 on the component.
     */
    BUTTON2(1 shl 2),

    /**
     * Enables op3 on the component.
     */
    BUTTON3(1 shl 3),

    /**
     * Enables op4 on the component.
     */
    BUTTON4(1 shl 4),

    /**
     * Enables op5 on the component.
     */
    BUTTON5(1 shl 5),

    /**
     * Enables op6 on the component.
     */
    BUTTON6(1 shl 6),

    /**
     * Enables op7 on the component.
     */
    BUTTON7(1 shl 7),

    /**
     * Enables op8 on the component.
     */
    BUTTON8(1 shl 8),

    /**
     * Enables op9 on the component.
     */
    BUTTON9(1 shl 9),

    /**
     * Enables op10 on the component.
     */
    BUTTON10(1 shl 10),

    /**
     * Enables the ability to target an item on the ground with the component.
     */
    OPOBJT(1 shl 11),

    /**
     * Enables the ability to target an NPC with the component.
     */
    OPNPCT(1 shl 12),

    /**
     * Enables the ability to target an object with the component.
     */
    OPLOCT(1 shl 13),

    /**
     * Enables the ability to target another player with the component.
     */
    OPPLAYERT(1 shl 14),

    /**
     * Enabled the ability to target an item in the players inventory with the component.
     */
    OPHELDT(1 shl 15),

    /**
     * Enables the ability to target another component with the component. Requires [.TARGET] to be enabled on the components that
     * are targetable.
     */
    BUTTONT(1 shl 16),

    /**
     * Sets the component to be dragged to any parent up to depth of 1.
     */
    DRAG_DEPTH1(1 shl 17),

    /**
     * Sets the component to be dragged to any parent up to depth of 2.
     */
    DRAG_DEPTH2(2 shl 17),

    /**
     * Sets the component to be dragged to any parent up to depth of 3.
     */
    DRAG_DEPTH3(3 shl 17),

    /**
     * Sets the component to be dragged to any parent up to depth of 4.
     */
    DRAG_DEPTH4(4 shl 17),

    /**
     * Sets the component to be dragged to any parent up to depth of 5.
     */
    DRAG_DEPTH5(5 shl 17),

    /**
     * Sets the component to be dragged to any parent up to depth of 6.
     */
    DRAG_DEPTH6(6 shl 17),

    /**
     * Sets the component to be dragged to any parent up to depth of 7.
     */
    DRAG_DEPTH7(7 shl 17),

    /**
     * Sets the component to be able to be dragged to.
     */
    DRAG_TARGET(1 shl 20),

    /**
     * Enables the ability of [.BUTTONT] enabled components to target the component.
     */
    TARGET(1 shl 21);
    /**
     * Gets the flag for the event.
     */
}