/*
 * Copyright (c) pakoito 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacoworks.rxtuples;

import org.javatuples.Octet;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Septet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;

public final class RxTuples {
    private RxTuples() {
    }

    /* Pair */
    public static <T, U> rx.functions.Func2<T, U, Pair<T, U>> toPair() {
        return new Func2<T, U, Pair<T, U>>() {
            @Override
            public Pair<T, U> call(T t, U t2) {
                return Pair.with(t, t2);
            }
        };
    }

    /* Triplet */
    public static <A, B, C> Func3<A, B, C, Triplet<A, B, C>> toTriplet() {
        return new Func3<A, B, C, Triplet<A, B, C>>() {
            @Override
            public Triplet<A, B, C> call(A a, B b, C c) {
                return Triplet.with(a, b, c);
            }
        };
    }

    public static <A, B, T> rx.functions.Func2<T, Pair<A, B>, Triplet<T, A, B>> toTripletFromSingle() {
        return new Func2<T, Pair<A, B>, Triplet<T, A, B>>() {
            @Override
            public Triplet<T, A, B> call(T t, Pair<A, B> objects) {
                return Triplet.with(t, objects.getValue0(), objects.getValue1());
            }
        };
    }

    public static <A, B, T> Func2<Pair<A, B>, T, Triplet<A, B, T>> toTripletFromPair() {
        return new Func2<Pair<A, B>, T, Triplet<A, B, T>>() {
            @Override
            public Triplet<A, B, T> call(Pair<A, B> objects, T t) {
                return Triplet.with(objects.getValue0(), objects.getValue1(), t);
            }
        };
    }
}
