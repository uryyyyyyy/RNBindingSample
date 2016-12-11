//
//  MyLogSwift.swift
//  RNBindingSample
//
//  Created by 柴田幸輝 on 2016/12/11.
//  Copyright © 2016年 Facebook. All rights reserved.
//

import Foundation
import MediaPlayer

@objc(MyLogSwift)
class MyLogSwift: NSObject {

  @objc(callFunc:dict:findEvents:)
  func callFunc(param: NSString, dict: NSDictionary, callback: RCTResponseSenderBlock) {
    let str = "hello"
    NSLog(str)
    NSLog("param: " + (param as String));
    //NSLog("dict: " + dict);

    let obj: Dictionary<String, String> = ["foo": "bar", "hey": "ho"]

    callback([NSNull(), obj]);
  }

}
