package com.layneyiu.forecast.domain.command

/**
 * ---------------------------------------------------------
 *
 * Created by Frank on 2020/4/20.
 * <a href="mailto:frankyao10110@gmail.com">Contact me</a>
 * ---------------------------------------------------------
 */
public interface Command<T> {
    fun execute(): T
}