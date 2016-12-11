//
//  MyLog.m
//  RNBindingSample
//
//  Created by 柴田幸輝 on 2016/12/11.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "MyLog.h"

@implementation MyLog

RCT_EXPORT_MODULE(MyLog);
RCT_EXPORT_METHOD(callFunc:(NSString *)param dict:(NSDictionary*)dict findEvents:(RCTResponseSenderBlock)callback)
{
  NSLog(@"param:  %@", param);
  NSLog(@"dict: %@", dict);
  
  callback(@[ [NSNull null], @{ @"hoge": @"val" } ]);
}


@end
