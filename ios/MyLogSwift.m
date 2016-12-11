//
//  MyLogSwift.m
//  RNBindingSample
//
//  Created by 柴田幸輝 on 2016/12/11.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(MyLogSwift, NSObject)

RCT_EXTERN_METHOD(callFunc:(NSString *)param dict:(NSDictionary*)dict findEvents:(RCTResponseSenderBlock)callback)

@end
