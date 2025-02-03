import { TurboModule, TurboModuleRegistry } from "react-native";
import type {EventEmitter} from 'react-native/Libraries/Types/CodegenTypes';

export interface Spec extends TurboModule {
  add(a: number, b: number): Promise<number>;
  readonly onValueChanged: EventEmitter<number>;
  create(): Promise<boolean>;
  setOptionString(option:string, setting:string): Promise<boolean>;
  useDefaultOptions(): Promise<boolean>;
  init(): Promise<boolean>;
  command(orders:string[]): Promise<boolean>;
  play(url:string): Promise<boolean>;
  destroy():Promise<boolean>;
  detachSurface():Promise<boolean>;
  cleanup():Promise<boolean>;
}

export default TurboModuleRegistry.get<Spec>("Libmpv") as Spec | null;