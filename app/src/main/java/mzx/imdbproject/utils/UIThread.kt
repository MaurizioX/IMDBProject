package mzx.imdbproject.utils

/*
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copied from https://github.com/android10/Android-CleanArchitecture and converted to Kotlin.
 */




import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import mzx.imdbproject.domain.executor.PostExecutionThread
import javax.inject.Inject

/**
 * This class provides main UI thread.
 */
class UIThread @Inject constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}