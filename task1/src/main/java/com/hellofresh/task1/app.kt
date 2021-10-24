package com.hellofresh.task1

import com.hellofresh.task1.service.IFilterService
import com.hellofresh.task1.service.ISelectionInfoService
import com.hellofresh.task1.service.ISelectionService
import com.hellofresh.task1.service.IUnSelectionService

interface Env: ISelectionService,
        ISelectionInfoService,
        IUnSelectionService,
        IFilterService
