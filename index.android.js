/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

import MySlider from './MySlider'
import MyTextView from './MyTextView'
import MyEditText from './MyEditText'

export default class RNBindingSample extends Component {
  render() {
    return (
      <View>
        <MySlider value={50} />
        <MyTextView value="hello world" style={{height: 50, width: 800}} />
        <MyEditText value="haha" style={{height: 100, width: 800}} />
      </View>
    );
  }
}

AppRegistry.registerComponent('RNBindingSample', () => RNBindingSample);
