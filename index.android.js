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

import MyTextView from './MyTextView'

export default class RNBindingSample extends Component {
  render() {
    return (
      <View>
        <MyTextView text="helloaaaaaa" />
        <MyTextView text="helloaaaaaa" />
      </View>
    );
  }
}

AppRegistry.registerComponent('RNBindingSample', () => RNBindingSample);
