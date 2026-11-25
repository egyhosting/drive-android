/*
 * Nextcloud - Android Client
 *
 * SPDX-FileCopyrightText: 2024 Tobias Kaminsky <tobias.kaminsky@nextcloud.com>
 * SPDX-License-Identifier: AGPL-3.0-or-later
 */
package com.nextcloud.utils

import com.owncloud.android.BuildConfig

object BuildHelper {
    // EgyHosting: the "egyhosting" flavor ships on Google Play, so it follows the Play rules too.
    fun isFlavourGPlay(): Boolean = BuildConfig.FLAVOR == "gplay" || BuildConfig.FLAVOR == "egyhosting"

    fun isHuaweiFlavor(): Boolean = BuildConfig.FLAVOR == "huawei"
}
