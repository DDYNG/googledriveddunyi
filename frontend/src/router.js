
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import DriveDriveManager from "./components/listers/DriveDriveCards"
import DriveDriveDetail from "./components/listers/DriveDriveDetail"

import IndexerIndexerManager from "./components/listers/IndexerIndexerCards"
import IndexerIndexerDetail from "./components/listers/IndexerIndexerDetail"

import VideoProcessingVideoprocessingManager from "./components/listers/VideoProcessingVideoprocessingCards"
import VideoProcessingVideoprocessingDetail from "./components/listers/VideoProcessingVideoprocessingDetail"

import NotificationNotificationManager from "./components/listers/NotificationNotificationCards"
import NotificationNotificationDetail from "./components/listers/NotificationNotificationDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/drives/drives',
                name: 'DriveDriveManager',
                component: DriveDriveManager
            },
            {
                path: '/drives/drives/:id',
                name: 'DriveDriveDetail',
                component: DriveDriveDetail
            },

            {
                path: '/indexers/indexers',
                name: 'IndexerIndexerManager',
                component: IndexerIndexerManager
            },
            {
                path: '/indexers/indexers/:id',
                name: 'IndexerIndexerDetail',
                component: IndexerIndexerDetail
            },

            {
                path: '/videoProcessings/videoprocessings',
                name: 'VideoProcessingVideoprocessingManager',
                component: VideoProcessingVideoprocessingManager
            },
            {
                path: '/videoProcessings/videoprocessings/:id',
                name: 'VideoProcessingVideoprocessingDetail',
                component: VideoProcessingVideoprocessingDetail
            },

            {
                path: '/notifications/notifications',
                name: 'NotificationNotificationManager',
                component: NotificationNotificationManager
            },
            {
                path: '/notifications/notifications/:id',
                name: 'NotificationNotificationDetail',
                component: NotificationNotificationDetail
            },




    ]
})
