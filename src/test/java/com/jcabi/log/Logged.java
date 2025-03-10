/*
 * Copyright (c) 2012-2025 Yegor Bugayenko
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.log;

import java.util.Formattable;
import java.util.FormattableFlags;

/**
 * Logs decor.
 *
 * @since 0.1
 */
public final class Logged {

    /**
     * The decor.
     */
    private final transient Formattable decor;

    /**
     * Formatting flags.
     */
    private final transient int flags;

    /**
     * Formatting width.
     */
    private final transient int width;

    /**
     * Formatting precision.
     */
    private final transient int precision;

    /**
     * Public ctor.
     * @param dcr Decor
     * @param flgs Flags
     * @param wdt Width
     * @param prcs Precision
     * @checkstyle ParameterNumber (3 lines)
     */
    public Logged(final Formattable dcr,
        final int flgs, final int wdt, final int prcs) {
        this.decor = dcr;
        this.flags = flgs;
        this.width = wdt;
        this.precision = prcs;
    }

    @Override
    public String toString() {
        final StringBuilder format = new StringBuilder(0);
        format.append('%');
        if ((this.flags & FormattableFlags.LEFT_JUSTIFY) == FormattableFlags
            .LEFT_JUSTIFY) {
            format.append('-');
        }
        if (this.width > 0) {
            format.append(this.width);
        }
        if (this.precision > 0) {
            format.append('.').append(this.precision);
        }
        if ((this.flags & FormattableFlags.UPPERCASE) == FormattableFlags
            .UPPERCASE) {
            format.append('S');
        } else {
            format.append('s');
        }
        return Logger.format(format.toString(), this.decor);
    }

}
